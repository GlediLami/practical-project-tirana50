package org.sda.dto.location;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CityDto {

    @JsonProperty("Key")
    private String cityId;

    @JsonProperty("LocalizedName")
    private String localizedName;
}
