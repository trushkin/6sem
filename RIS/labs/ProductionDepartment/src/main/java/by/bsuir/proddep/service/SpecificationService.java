package by.bsuir.proddep.service;

import by.bsuir.proddep.repository.SpecificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpecificationService {
    private final SpecificationRepository specificationRepository;

}
