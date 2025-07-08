package murillo.com.br.fast_double_click.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class RegistroTempo {
  
  String tempo;

  @JsonFormat(pattern = "yyyy-MM-dd")
  LocalDate data;
}
