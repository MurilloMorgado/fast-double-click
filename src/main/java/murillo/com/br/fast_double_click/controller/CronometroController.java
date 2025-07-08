package murillo.com.br.fast_double_click.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import murillo.com.br.fast_double_click.model.RegistroTempo;
import murillo.com.br.fast_double_click.service.CronometroService;

@RestController
@RequestMapping("cronometro/")
@RequiredArgsConstructor
public class CronometroController {

  private final CronometroService cronometroService;

  @GetMapping
  public ResponseEntity<List<RegistroTempo>> listarTempos() {

    List<RegistroTempo> listaDeTempos = cronometroService.listarTempos();

    return ResponseEntity.ok().body(listaDeTempos);
  }

  @PostMapping
  public ResponseEntity<Void> salvarTempo(@RequestBody RegistroTempo registroTempo) {

    cronometroService.registrarTempo(registroTempo);

    return ResponseEntity.ok().build();
  }

}
