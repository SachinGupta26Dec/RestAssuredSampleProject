package pojos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class GetPlaceResponse {

	@AllArgsConstructor
	@NoArgsConstructor
	@Getter
	@Setter
	@ToString
	public class Location {

		double latitude;
		double longitude;
	}

	Location location;
	String accuracy;
	String name;
	String phone_number;
	String address;
	String types;
	String website;
	String language;
}
