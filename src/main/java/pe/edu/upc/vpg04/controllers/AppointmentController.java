package pe.edu.upc.vpg04.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.vpg04.dtos.*;
import pe.edu.upc.vpg04.entities.Appointment;
import pe.edu.upc.vpg04.servicesinterfaces.IAppointmentService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/citas")
public class AppointmentController {
    @Autowired
    private IAppointmentService aS;
    @PostMapping("/registrar")
    @PreAuthorize("hasAnyAuthority('VETERANO','PSICOLOGO','ADMINISTRADOR')")
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
    @GetMapping
   @PreAuthorize("hasAnyAuthority('VETERANO','ADMINISTRADOR')")
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
    @GetMapping("/citasporfechas")
    public List<AppointmentbyDateDTO> appointmentbydate(@RequestParam LocalDate date1){
        List<String[]> list = aS.citasporFecha(date1);
        List<AppointmentbyDateDTO> listdto = new ArrayList<>();
        for(String[] columna : list){
            AppointmentbyDateDTO dto = new AppointmentbyDateDTO();
            dto.setPsychologyId(Integer.parseInt(columna[0]));
            dto.setVeteranId(Integer.parseInt(columna[1]));
            dto.setAppointmentDate(LocalDate.parse(columna[2]));
            listdto.add(dto);
        }
        return listdto;
    }
    @GetMapping("/citasCanceladas")
    public List<CancelledAppointmentsDTO> cancelledAppointments(){
        List<String[]> list = aS.citasCanceladas();
        List<CancelledAppointmentsDTO> listdto = new ArrayList<>();
        for(String[] columna : list){
            CancelledAppointmentsDTO dto = new CancelledAppointmentsDTO();
            dto.setIdAppointment(Integer.parseInt(columna[0]));
            dto.setAppointmentDate(LocalDate.parse(columna[1]));
            dto.setStatus(columna[2]);
            dto.setName(columna[3]);
            dto.setPsychologyLastname(columna[4]);
            dto.setVeteranLastname(columna[5]);
            listdto.add(dto);
        }
        return listdto;
    }

}
