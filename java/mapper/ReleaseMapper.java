package ru.nogen.projectManagement.mapper.project;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.nogen.projectManagement.dto.project.ReleaseDto;
import ru.nogen.projectManagement.mapper.AbstractMapper;
import ru.nogen.projectManagement.model.project.Release;
import ru.nogen.projectManagement.repository.project.ProjectRepository;

@Component
public class ReleaseMapper extends AbstractMapper<Release, ReleaseDto> {

    private final ModelMapper mapper;
    private final ProjectRepository projectRepository;

    @Autowired
    public ReleaseMapper(ModelMapper mapper, ProjectRepository projectRepository) {
        super(Release.class, ReleaseDto.class);
        this.mapper = mapper;
        this.projectRepository = projectRepository;
    }

//    @PostConstruct
//    public void setupMapper() {
//        mapper.createTypeMap(Release.class, ReleaseDto.class)
//                .addMappings(m -> m.skip(ReleaseDto::setProjectId)).setPostConverter(toDtoConverter());
//        mapper.createTypeMap(ReleaseDto.class, Release.class)
//                .addMappings(m -> m.skip(Release::setProject)).setPostConverter(toEntityConverter());
//    }
//
//    @Override
//    public void mapSpecificFields(Release source, ReleaseDto destination) {
//        destination.setProjectId(getProjectId(source));
//    }
//
//    private UUID getProjectId(Release source) {
//        return Objects.isNull(source) || Objects.isNull(source.getId()) || Objects.isNull(source.getProject()) ? null : source.getProject().getId();
//    }
//
//    @Override
//    public void mapSpecificFields(ReleaseDto source, Release destination) {
//        destination.setProject(projectRepository.findById(source.getProjectId()).orElse(null));
//    }
}
