package pe.edu.upc.vpg04.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.vpg04.dtos.EventDTO;
import pe.edu.upc.vpg04.dtos.QuantityEventbyPsichologistDTO;
import pe.edu.upc.vpg04.dtos.QuantityVeteraninEventDTO;
import pe.edu.upc.vpg04.entities.Event;
import pe.edu.upc.vpg04.servicesinterfaces.IEventService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/eventos")
public class EventController {
    @Autowired
    private IEventService eS;
    @GetMapping
    //@PreAuthorize("hasAnyAuthority('PSICOLOGO', 'VETERANO')")
    public List<EventDTO> listar() {
        return eS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, EventDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    // @PreAuthorize("hasAnyAuthority('PSICOLOGO')")
    public void insertar(@RequestBody EventDTO edto) {
        ModelMapper m = new ModelMapper();
        Event e= m.map(edto, Event.class);
        eS.insert(e);
    }

    @DeleteMapping("/{id}")
    //@PreAuthorize("hasAnyAuthority('PSICOLOGO')")
    public void eliminar(@PathVariable("id")Integer id){
        eS.delete(id);
    }

    @PutMapping
    //@PreAuthorize("hasAnyAuthority('PSICOLOGO')")
    public void modificar(@RequestBody EventDTO edto) {
        ModelMapper m = new ModelMapper();
        Event e= m.map(edto, Event.class);
        eS.update(e);
    }

    @GetMapping("/busquedas")
    public List<EventDTO> BuscarEvento(@RequestParam String n) {
        return eS.buscar(n).stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, EventDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/quantityinEvent")
    public List<QuantityVeteraninEventDTO> quantityVeteraninEvents(){
        List<String[]> list = eS.cantidadVeteranosporEvento();
        List<QuantityVeteraninEventDTO> listdto = new ArrayList<>();
        for(String[] columna : list){
            QuantityVeteraninEventDTO dto = new QuantityVeteraninEventDTO();
            dto.setVeteranId(Integer.parseInt(columna[0]));
            dto.setQuantityveter(Integer.parseInt(columna[1]));
            listdto.add(dto);
        }
        return listdto;
    }

    @GetMapping("/quantityEventbyPsico")
    public List<QuantityEventbyPsichologistDTO> quantityEventbyPsico(){
        List<String[]> list = eS.cantidadEventoporPsicologo();
        List<QuantityEventbyPsichologistDTO> listdto = new ArrayList<>();
        for(String[] columna : list){
            QuantityEventbyPsichologistDTO dto = new QuantityEventbyPsichologistDTO();
            dto.setPsicoId(Integer.parseInt(columna[0]));
            dto.setQuantitypsico(Integer.parseInt(columna[1]));
            listdto.add(dto);
        }
        return listdto;
    }
}
