package pl.springacademy.aspectmailsender.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @NonNull
    private int id;
    @NotBlank
    private String title;
    @Min(value = 1888)
    private Integer yearOfPremiere;
    @NotBlank
    private String director;
}
