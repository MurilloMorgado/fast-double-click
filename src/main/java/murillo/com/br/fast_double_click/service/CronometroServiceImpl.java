package murillo.com.br.fast_double_click.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
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
  private final File arquivo;

  public CronometroServiceImpl() {
    this.objectMapper = new ObjectMapper();
    this.objectMapper.registerModule(new JavaTimeModule());
    this.objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

    this.arquivo = new File("./data/registros.json");
    if (!arquivo.exists()) {
      try {
        arquivo.getParentFile().mkdirs();
        arquivo.createNewFile();
        objectMapper.writeValue(arquivo, List.of());
      } catch (IOException e) {
        throw new RuntimeException("Erro ao criar arquivo registros.json", e);
      }
    }
  }

  @Override
  public List<RegistroTempo> listarTempos() {

    try {
      File arquivo = this.arquivo;

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
    try {
      List<RegistroTempo> registros = listarTempos();

      registroTempo.setData(LocalDate.now());
      registros.add(registroTempo);

      objectMapper.writeValue(arquivo, registros);

      return registroTempo;
    } catch (IOException e) {
      e.printStackTrace();
      throw new InternalError("Falha ao registrar o tempo");
    }
  }

}
