package pe.edu.upc.vpg04.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.vpg04.dtos.AppointmentDTO;
import pe.edu.upc.vpg04.dtos.QuantityAppointmentsAttendedByPsychologistTimeDTO;
import pe.edu.upc.vpg04.dtos.QuantityAppointmentsAttendedByUsersDTO;
import pe.edu.upc.vpg04.entities.Appointment;
import pe.edu.upc.vpg04.servicesinterfaces.IAppointmentService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/citas")
public class AppointmentController {
    @Autowired
    private IAppointmentService aS;
    @PostMapping("/registrar")
    @PreAuthorize("hasAnyAuthority('VETERANO','PSICOLOGO')")
    public void registrar ( @RequestBody AppointmentDTO appointmentDTO) {
        ModelMapper m = new ModelMapper();
        Appointment appointment = m.map(appointmentDTO, Appointment.class);
        aS.insert(appointment);
    }
    @PutMapping("/actualizar")
    public void modificar ( @RequestBody AppointmentDTO appointmentDTO) {
        ModelMapper m = new ModelMapper();
        Appointment appointment = m.map(appointmentDTO, Appointment.class);
        aS.update(appointment);
    }
    @GetMapping("/listar")
   @PreAuthorize("hasAnyAuthority('VETERANO')")
    public List<AppointmentDTO> listar() {
        return aS.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,AppointmentDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable("id")Integer id){
        aS.delete(id);
    }

    @GetMapping("/listar/{id}")
    public AppointmentDTO listarPorId(@PathVariable("id")Integer id){
        ModelMapper m = new ModelMapper();
        AppointmentDTO appointmentDTO = m.map(aS.listId(id), AppointmentDTO.class);
        return appointmentDTO;
    }
    @GetMapping("/quantity")
    public List<QuantityAppointmentsAttendedByUsersDTO> quantityAppointmentByUsers(){
        List<String[]> list = aS.cantidadCitasAtendidasPorUsuarios();
        List<QuantityAppointmentsAttendedByUsersDTO> listdto = new ArrayList<>();
        for(String[] columna : list){
            QuantityAppointmentsAttendedByUsersDTO dto = new QuantityAppointmentsAttendedByUsersDTO();
            dto.setIdUser(Integer.parseInt(columna[0]));
            dto.setNameUser(columna[1]);
            dto.setLastNameUser(columna[2]);
            dto.setQuantityAppointmentsAttended(Integer.parseInt(columna[3]));
            listdto.add(dto);
        }
        return listdto;
    }
    @GetMapping("/quantityPsicologo")
    public List<QuantityAppointmentsAttendedByPsychologistTimeDTO> quantityAppointmentByPsychologist(){
        List<String[]> list = aS.cantidadCitasAtendidasPorPsicologo();
        List<QuantityAppointmentsAttendedByPsychologistTimeDTO> listdto = new ArrayList<>();
        for(String[] columna : list){
            QuantityAppointmentsAttendedByPsychologistTimeDTO dto = new QuantityAppointmentsAttendedByPsychologistTimeDTO();
            dto.setPsychologistId(Integer.parseInt(columna[0]));
            dto.setPsychologistName(columna[1]);
            dto.setPsychologistLastName(columna[2]);
            dto.setQuantityAppointmentsAttended(Integer.parseInt(columna[3]));
            listdto.add(dto);
        }
        return listdto;
    }
}
