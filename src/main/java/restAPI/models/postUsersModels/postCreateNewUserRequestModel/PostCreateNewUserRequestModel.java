package restAPI.models.postUsersModels.postCreateNewUserRequestModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import static restAPI.utils.dataGenerator.UserDataGenerator.getFakerEmailAddress;
import static restAPI.utils.dataGenerator.UserDataGenerator.getFakerUserName;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class PostCreateNewUserRequestModel{

	@JsonProperty("gender")
	private String gender;

	@JsonProperty("name")
	private String name;

	@JsonProperty("email")
	private String email;

	@JsonProperty("status")
	private String status;

	public PostCreateNewUserRequestModel randomize() {
		this.name = getFakerUserName();
		this.email = getFakerEmailAddress();
		this.gender = "Male";
		this.status = "Active";

		return this;
	}
}