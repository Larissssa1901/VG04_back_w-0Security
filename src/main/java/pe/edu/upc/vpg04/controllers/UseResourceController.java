package pe.edu.upc.vpg04.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.vpg04.dtos.UseResourcesDTO;
import pe.edu.upc.vpg04.entities.UseResources;
import pe.edu.upc.vpg04.servicesinterfaces.IUseResourcesService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usorecurso")
public class UseResourceController {
    @Autowired
    private IUseResourcesService iurs;

    @GetMapping
    public List<UseResourcesDTO> listarusos()
    {
        return iurs.listaruso().stream().map(x->
        {
            ModelMapper m= new ModelMapper();
            return m.map(x, UseResourcesDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody UseResourcesDTO dto)
    {
        ModelMapper m= new ModelMapper();
        UseResources res =m.map(dto, UseResources.class);
        iurs.insert(res);
    }
}
