package chechi.homeworks.usercardb.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CarRequest {

    @NotBlank
    private String make;

    @NotBlank
    private String model;

    @NotBlank
    private String vin;

    @NotBlank
    private String plate;

    @NotNull
    private int userId;



}
