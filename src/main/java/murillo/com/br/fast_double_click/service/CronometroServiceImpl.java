package murillo.com.br.fast_double_click.service;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import murillo.com.br.fast_double_click.model.RegistroTempo;

@Service
public class CronometroServiceImpl implements CronometroService {

  private final ObjectMapper objectMapper;

  public CronometroServiceImpl() {
    this.objectMapper = new ObjectMapper();
    this.objectMapper.registerModule(new JavaTimeModule());
    this.objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
  }

  @Override
  public List<RegistroTempo> listarTempos() {

    try {
      InputStream arquivo = getClass()
          .getClassLoader()
          .getResourceAsStream("registros.json");

      if (arquivo == null) {
        throw new FileNotFoundException("Arquivo registros.json não encontrado em resources.");
      }
      return objectMapper.readValue(
          arquivo,
          new TypeReference<List<RegistroTempo>>() {
          });

    } catch (Exception e) {
      e.printStackTrace();
      throw new InternalError("Falha ao listar os tempos");
    }

  }

  @Override
  public RegistroTempo registrarTempo(RegistroTempo registroTempo) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'registrarTempo'");
  }

}
