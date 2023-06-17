package chechi.homeworks.usercardb.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CarResponse {


    @NotBlank
    private String make;

    @NotBlank
    private String model;

    @NotBlank
    private String vin;

    @NotBlank
    private String plate;

}
