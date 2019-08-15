package dto;

import java.lang.reflect.Type;

import com.fasterxml.jackson.core.type.TypeReference;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data

public class JsonEntity {
	
	String json;
	String collectionName;

}
