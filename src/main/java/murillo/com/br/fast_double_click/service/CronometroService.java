package murillo.com.br.fast_double_click.service;

import java.util.List;

import murillo.com.br.fast_double_click.model.RegistroTempo;

public interface CronometroService {
  
  List<RegistroTempo> listarTempos();

  RegistroTempo registrarTempo(RegistroTempo registroTempo);

}
