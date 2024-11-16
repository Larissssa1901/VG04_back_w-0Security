package pe.edu.upc.vpg04.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.vpg04.dtos.ForumDTO;
import pe.edu.upc.vpg04.dtos.MostActiveForumInatMonthDTO;
import pe.edu.upc.vpg04.dtos.QuantityForumByPsychologistDTO;
import pe.edu.upc.vpg04.entities.Forum;
import pe.edu.upc.vpg04.servicesinterfaces.IForumService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/foros")
public class ForumController {
    @Autowired
    private IForumService fS;
    @PostMapping
    @PreAuthorize("hasAnyAuthority('PSICOLOGO','ADMINISTRADOR')")
    public void registrar(@RequestBody ForumDTO forumDTO) {
        ModelMapper m = new ModelMapper();
        Forum forum = m.map(forumDTO, Forum.class);
        fS.insert(forum);
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('PSICOLOGO','ADMINISTRADOR')")
    public void modificar(@RequestBody ForumDTO forumDTO) {
        ModelMapper m = new ModelMapper();
        Forum forum = m.map(forumDTO, Forum.class);
        fS.update(forum);
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('PSICOLOGO','VETERANO','ADMINISTRADOR')")
    public List<ForumDTO> listar() {
        return fS.list().stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, ForumDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasAnyAuthority('PSICOLOGO','ADMINISTRADOR')")
    public void eliminar(@PathVariable("id") Integer id) {
        fS.delete(id);
    }

    @GetMapping("listar/{id}")
    @PreAuthorize("hasAnyAuthority('PSICOLOGO','ADMINISTRADOR')")
    public ForumDTO listarPorId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        ForumDTO forumDTO = m.map(fS.listId(id), ForumDTO.class);
        return forumDTO;
    }
    @GetMapping("/quantity(MostActiveForums)")
    @PreAuthorize("hasAnyAuthority('PSICOLOGO','ADMINISTRADOR')")
    public List<MostActiveForumInatMonthDTO> mostActiveForumsInTheLastMonths(){
        List<String[]> list = fS.ForosMasActivosEnElEltimoMes();
        List<MostActiveForumInatMonthDTO> listdto = new ArrayList<>();
        for(String[] columna : list){
            MostActiveForumInatMonthDTO dto = new MostActiveForumInatMonthDTO();
            dto.setForumId(Integer.parseInt(columna[0]));
            dto.setForumTitle(columna[1]);
            dto.setNumPosts(Integer.parseInt(columna[2]));
            listdto.add(dto);
        }
        return listdto;
    }
    @GetMapping("/quantity(ForumsByPsy)")
    @PreAuthorize("hasAnyAuthority('PSICOLOGO','ADMINISTRADOR')")
    public List<QuantityForumByPsychologistDTO> quantityForumsByPsichologyst(){
        List<String[]> list = fS.CantidadDeForosQueTieneUnPsicologo ();
        List<QuantityForumByPsychologistDTO> listdto = new ArrayList<>();
        for(String[] columna : list){
            QuantityForumByPsychologistDTO dto = new QuantityForumByPsychologistDTO();
            dto.setPsychologistname(columna[0]);
            dto.setPsychologistlastName(columna[1]);
            dto.setForumCount(Integer.parseInt(columna[2]));
            listdto.add(dto);
        }
        return listdto;
    }
}

