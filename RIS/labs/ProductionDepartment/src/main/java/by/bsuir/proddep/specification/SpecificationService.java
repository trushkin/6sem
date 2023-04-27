package by.bsuir.proddep.specification;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpecificationService {
    private final SpecificationRepository specificationRepository;

}
