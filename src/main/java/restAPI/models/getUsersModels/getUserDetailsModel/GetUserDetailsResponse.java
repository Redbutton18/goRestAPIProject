package restAPI.models.getUsersModels.getUserDetailsModel;

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
public class GetUserDetailsResponse {

	@JsonProperty("code")
	private Integer code;

	@JsonProperty("data")
	private Data data;

	@JsonProperty("meta")
	private Object meta;
}