package tacos;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.Data;

@Data
@Table("ingredients")
public class Ingredient {
	
	@PrimaryKey
	private final String id;
	private final String name;
	private final Type type;
	
	public enum Type{
		WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
	}

}
