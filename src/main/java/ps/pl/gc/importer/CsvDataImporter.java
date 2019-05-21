package ps.pl.gc.importer;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import ps.pl.gc.model.Employee;


@Configuration
@EnableBatchProcessing
public class CsvDataImporter {

    private final JobBuilderFactory jobBuilderFactory;

    private final StepBuilderFactory stepBuilderFactory;

    private final DatabaseItemWriter<Employee> databaseItemWriter;

    public CsvDataImporter(
            JobBuilderFactory jobBuilderFactory,
            StepBuilderFactory stepBuilderFactory,
            DatabaseItemWriter<Employee> databaseItemWriter
    ) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
        this.databaseItemWriter = databaseItemWriter;
    }

    @Bean
    public Step readFromCsv() {
        return stepBuilderFactory.get("readFromCsv").<Employee, Employee>chunk(10000)
                .reader(csvEmployeeReader())
                .writer(databaseItemWriter)
                .build();
    }

    @Bean
    public Job readCSVFilesJob() {
        return jobBuilderFactory
                .get("readCSVFilesJob")
                .incrementer(new RunIdIncrementer())
                .start(readFromCsv())
                .build();
    }

    @Bean
    public FlatFileItemReader<Employee> csvEmployeeReader(){
        FlatFileItemReader<Employee> reader = new FlatFileItemReader<>();
        reader.setResource(new ClassPathResource("employees.csv"));
        reader.setLinesToSkip(1);
        reader.setLineMapper(new DefaultLineMapper<Employee>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames("id", "email", "username", "firstName", "lastName", "shortGenderfa" +
                        "", "gender", "street", "streetNumber", "city", "ipAddress", "company");
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<Employee>() {{
                setTargetType(Employee.class);
            }});
        }});
        return reader;
    }
}