package telran.library.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import telran.library.domain.entities.AuthorEntity;
import telran.library.domain.entities.BookEntity;
import telran.library.domain.entities.PublisherEntity;
import telran.library.domain.entities.ReaderEntity;
import telran.library.domain.entities.RecordEntity;
import telran.library.dto.Book;
import telran.library.dto.PublisherAuthor;
import telran.library.dto.Reader;
import telran.library.dto.Record;
import telran.library.mappers.AuthorMapper;
import telran.library.mappers.BookMapper;
import telran.library.mappers.Mapper;
import telran.library.mappers.PublisherMapper;
import telran.library.mappers.ReaderMapper;
import telran.library.mappers.RecordMapper;


@Configuration
public class MapperConfiguration {     
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setSkipNullEnabled(true);
        return mapper;
    }

    @Bean
    public Mapper authorMapper(){
        return new AuthorMapper(AuthorEntity.class, PublisherAuthor.class);
    }

    @Bean
    public Mapper publisherMapper(){
        return new PublisherMapper(PublisherEntity.class, PublisherAuthor.class);
    }

    @Bean
    public Mapper bookMapper(){
        return new BookMapper(BookEntity.class, Book.class);
    }

    @Bean
    public Mapper readerMapper(){
        return new ReaderMapper(ReaderEntity.class, Reader.class);
    }

    @Bean
    public Mapper recordMapper(){
        return new RecordMapper(RecordEntity.class, Record.class);
    }
}
