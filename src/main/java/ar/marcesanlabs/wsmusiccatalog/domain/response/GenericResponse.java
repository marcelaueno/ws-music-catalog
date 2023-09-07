package ar.marcesanlabs.wsmusiccatalog.domain.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenericResponse {
    private Boolean status;
    private String description;
}
