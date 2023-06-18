package chechi.homeworks.usercardb.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CarResponse {

    @NotNull
    private int id;

    @NotBlank
    private String make;

    @NotBlank
    private String model;

    @NotBlank
    private String vin;

    @NotBlank
    private String plate;

}
