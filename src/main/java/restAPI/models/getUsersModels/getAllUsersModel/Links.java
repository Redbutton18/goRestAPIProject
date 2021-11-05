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
public class Links{

	@JsonProperty("next")
	private String next;

	@JsonProperty("current")
	private String current;

	@JsonProperty("previous")
	private Object previous;

	public String getNext(){
		return next;
	}

	public String getCurrent(){
		return current;
	}

	public Object getPrevious(){
		return previous;
	}
}