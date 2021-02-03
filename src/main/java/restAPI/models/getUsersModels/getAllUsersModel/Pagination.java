package restAPI.models.getUsersModels.getAllUsersModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class Pagination{

	@JsonProperty("total")
	private Integer total;

	@JsonProperty("pages")
	private Integer pages;

	@JsonProperty("limit")
	private Integer limit;

	@JsonProperty("page")
	private Integer page;
}