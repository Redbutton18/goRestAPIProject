package restAPI.models.getUsersModels.getAllUsersModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class GetAllUsersResponseModel {

	@JsonProperty("data")
	private List<DataItem> data;

	@JsonProperty("meta")
	private Meta meta;

	public List<DataItem> getData(){
		return data;
	}

	public Meta getMeta(){
		return meta;
	}
}