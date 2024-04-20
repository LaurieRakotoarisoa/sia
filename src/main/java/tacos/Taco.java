package tacos;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import com.datastax.oss.driver.api.core.uuid.Uuids;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Table("tacos")
public class Taco {
	
	@PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
	private UUID id=Uuids.timeBased();
	
	@PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED)
	private Date createdAt = new Date();
	
	@NotNull
	@Size(min = 5, message = "Name must be at least 5 characters long")
	private String name;
	
	@NotNull
	@Size(min = 1, message = "You must choose at least 1 ingredient")
	private List<IngredientUDT> ingredients;
	
	public void addIngredient(IngredientUDT ingredient) {
		this.ingredients.add(ingredient);
	}

}
