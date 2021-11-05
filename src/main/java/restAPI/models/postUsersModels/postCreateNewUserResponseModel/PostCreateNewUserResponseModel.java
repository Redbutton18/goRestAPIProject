package restAPI.models.postUsersModels.postCreateNewUserResponseModel;

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
public class PostCreateNewUserResponseModel {

	@JsonProperty("data")
	private Data data;

	@JsonProperty("meta")
	private Object meta;

	public Data getData(){
		return data;
	}

	public Object getMeta(){
		return meta;
	}
}