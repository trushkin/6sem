package by.bsuir.proddep.specification;

import by.bsuir.proddep.productionOrder.ProductionOrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpecificationService {
    @Autowired
    private  SpecificationRepository specificationRepository;
    private final SpecificationMapper specificationMapper;

    public SpecificationDto addSpecification(SpecificationDto specificationDto){
        Specification specification = specificationRepository.save(specificationMapper.toSpecificationEntity(specificationDto));
        return specificationMapper.toSpecificationDto(specification);
    }
    public List<SpecificationDto> getAllSpecifications(){
        return specificationRepository.findAllByOrderByIdDesc().stream().map(specificationMapper::toSpecificationDto).toList();
    }
    public SpecificationDto getSpecificationById(Integer id){
        return specificationMapper.toSpecificationDto(specificationRepository.findById(id).get());
    }
    public SpecificationDto updateSpecification(SpecificationRequestToUpdate specificationRequestToUpdate){
        Specification entitySpecification = specificationRepository.findById(specificationRequestToUpdate.getId()).get();
        entitySpecification.setActive(specificationRequestToUpdate.isActive());
        Specification updatedSpecification = specificationRepository.save(entitySpecification);
        return specificationMapper.toSpecificationDto(updatedSpecification);
    }
}
