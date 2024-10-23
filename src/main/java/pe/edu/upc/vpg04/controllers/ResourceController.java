package pe.edu.upc.vpg04.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.vpg04.dtos.ForumDTO;
import pe.edu.upc.vpg04.dtos.LessUsedResourceDTO;
import pe.edu.upc.vpg04.dtos.MostUsebetweendateDTO;
import pe.edu.upc.vpg04.dtos.ResourceDTO;
import pe.edu.upc.vpg04.entities.Forum;
import pe.edu.upc.vpg04.entities.Resource;
import pe.edu.upc.vpg04.servicesinterfaces.IResourceService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/recursos")
public class ResourceController {

    @Autowired
    private IResourceService rS;

    @GetMapping
   // @PreAuthorize("hasAnyAuthority('PSICOLOGO')")
    public List<Resource> listarecursos()
    {
        return rS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,Resource.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    //@PreAuthorize("hasAnyAuthority('PSICOLOGO')")
    public void insertar(@RequestBody ResourceDTO dto)
    {
        ModelMapper m=new ModelMapper();
        Resource r=m.map(dto,Resource.class);
        rS.insert(r);
    }

    @PutMapping
    public void modificar(@RequestBody ResourceDTO resourceDTO) {
        ModelMapper m = new ModelMapper();
        Resource resource = m.map(resourceDTO, Resource.class);
        rS.update(resource);
    }

    @DeleteMapping("/eliminar/{id}")
    //@PreAuthorize("hasAnyAuthority('PSICOLOGO')")
    public void eliminar(@PathVariable("id") Integer id) {
        rS.delete(id);
    }

    @GetMapping("/listar/{id}")
    //@PreAuthorize("hasAnyAuthority('PSICOLOGO')")
    public ResourceDTO listarPorId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        ResourceDTO resourceDTO = m.map(rS.listId(id), ResourceDTO.class);
        return resourceDTO;
    }
    @GetMapping("/menosutilizado")
    //@PreAuthorize("hasAnyAuthority('PSICOLOGO')")
    public List<LessUsedResourceDTO> Recursomenosutilizado()
    {
        List<String[]> lista=rS.Rmenosutilizado();
        List<LessUsedResourceDTO> listdto=new ArrayList<>();
        for(String[] column:lista)
        {
            LessUsedResourceDTO dto=new LessUsedResourceDTO();
            dto.setTiporecurso(column[0]);
            dto.setTotalusos(Integer.parseInt(column[1]));
            listdto.add(dto);
        }
        return listdto;
    }
    @GetMapping("/maasutilizadoportiempo")
    //@PreAuthorize("hasAnyAuthority('PSICOLOGO')")
    public List<MostUsebetweendateDTO> recursomasutilizadoportiempo(@RequestParam LocalDate fechainicio, @RequestParam LocalDate fechafin) {
        List<String[]> lista = rS.tiporecursomasutilizad(fechainicio, fechafin);
        List<MostUsebetweendateDTO> listadto = new ArrayList<>();
        for (String[] columna : lista) {
            MostUsebetweendateDTO dto = new MostUsebetweendateDTO();
            dto.setTiporecurso(columna[0]);
            dto.setTotalusos(Integer.parseInt(columna[1]));
            listadto.add(dto);
        }
        return listadto;
    }


}
