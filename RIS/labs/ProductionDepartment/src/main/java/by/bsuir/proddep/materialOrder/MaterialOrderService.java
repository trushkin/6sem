package by.bsuir.proddep.materialOrder;

import by.bsuir.proddep.employee.Employee;
import by.bsuir.proddep.employee.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MaterialOrderService {
    @Autowired
    private MaterialOrderRepository materialOrderRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    private final MaterialOrderMapper materialOrderMapper;


    public MaterialOrderDto addMaterialOrder(MaterialOrderDto materialOrderDto) {
        MaterialOrder materialOrder = materialOrderRepository.save(materialOrderMapper.toMaterialOrderEntity(materialOrderDto));
        return materialOrderMapper.toMaterialOrderDto(materialOrder);
    }

    public MaterialOrderDto updateMaterialOrder(MaterialOrderRequestToUpdate materialOrderRequestToUpdate) {
        MaterialOrder entityMaterialOrder = materialOrderRepository.findById(materialOrderRequestToUpdate.getId()).get();
        entityMaterialOrder.setStatus(materialOrderRequestToUpdate.getStatus());
        MaterialOrder updatedMaterialOrder = materialOrderRepository.save(entityMaterialOrder);
        return materialOrderMapper.toMaterialOrderDto(updatedMaterialOrder);
    }

    public List<MaterialOrderDto> getMaterialOrdersByWorker() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Employee employee = employeeRepository.findByEmail(authentication.getName()).get();
        return materialOrderRepository.findByEmployee_Id(employee.getId()).stream().map(materialOrderMapper::toMaterialOrderDto).toList();
    }
}
