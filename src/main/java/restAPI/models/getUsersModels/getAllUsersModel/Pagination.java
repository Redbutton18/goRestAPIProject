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
	private int total;

	@JsonProperty("pages")
	private int pages;

	@JsonProperty("limit")
	private int limit;

	@JsonProperty("links")
	private Links links;

	@JsonProperty("page")
	private int page;

	public int getTotal(){
		return total;
	}

	public int getPages(){
		return pages;
	}

	public int getLimit(){
		return limit;
	}

	public Links getLinks(){
		return links;
	}

	public int getPage(){
		return page;
	}
}