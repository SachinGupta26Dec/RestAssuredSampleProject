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
public class AddPlacePayload {

	@AllArgsConstructor
	@NoArgsConstructor
	@Getter
	@Setter
	@ToString
	public class Location {

		double lat;
		double lng;
	}

	Location location;
	int accuracy;
	String name;
	String phoneNumber;
	String address;
	String[] types;
	String website;
	String language;
}
