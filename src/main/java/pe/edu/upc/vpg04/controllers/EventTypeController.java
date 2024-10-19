package pe.edu.upc.vpg04.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.vpg04.dtos.EventTypeDTO;
import pe.edu.upc.vpg04.entities.EventType;
import pe.edu.upc.vpg04.servicesinterfaces.IEventTypeService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tipoevento")
public class EventTypeController {
    @Autowired
    private IEventTypeService etS;

    @GetMapping
    public List<EventTypeDTO> list() {
        return etS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, EventTypeDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody EventTypeDTO dto) {
        ModelMapper m = new ModelMapper();
        EventType et = m.map(dto, EventType.class);
        etS.insert(et);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        etS.delete(id);
    }

    @PutMapping
    public void modificar(@RequestBody EventTypeDTO dto) {
        ModelMapper m = new ModelMapper();
        EventType d = m.map(dto, EventType.class);
        etS.update(d);
    }
}
