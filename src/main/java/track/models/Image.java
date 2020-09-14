package track.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "image_seq")
    private Integer id;

    private Integer height;
    private Integer width;
    private String url;

}
