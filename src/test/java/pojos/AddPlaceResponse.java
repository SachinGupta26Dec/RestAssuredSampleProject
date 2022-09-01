package pojos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddPlaceResponse {

	String status;
	String place_id;
	String scope;
	String reference;
	String id;
}
