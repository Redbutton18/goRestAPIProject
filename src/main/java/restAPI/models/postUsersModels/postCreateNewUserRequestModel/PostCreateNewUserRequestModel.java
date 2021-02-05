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
	private Object gender;

	@JsonProperty("name")
	private Object name;

	@JsonProperty("email")
	private Object email;

	@JsonProperty("status")
	private Object status;

	public PostCreateNewUserRequestModel randomize() {
		this.name = getFakerUserName();
		this.email = getFakerEmailAddress();
		this.gender = "Male";
		this.status = "Active";

		return this;
	}
}