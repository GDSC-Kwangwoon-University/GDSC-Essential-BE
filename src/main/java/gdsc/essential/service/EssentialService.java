package gdsc.essential.service;

import gdsc.essential.Entity.SubmitInfo;
import gdsc.essential.dto.request.SubmitInfoRequestDTO;
import gdsc.essential.dto.response.SubmitInfoResponseDTO;
import gdsc.essential.repository.EssentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EssentialService {
    private final EssentialRepository essentialRepository;

    @Autowired
    public EssentialService(EssentialRepository essentialRepository) {
        this.essentialRepository = essentialRepository;
    }

    public List<SubmitInfoResponseDTO> getAllSubmitInfos() {
        List<SubmitInfo> submitInfos = essentialRepository.findAll();
        List<SubmitInfoResponseDTO> submitInfoResponseDTOList = new ArrayList<>();

        for(SubmitInfo submitInfo: submitInfos){
            SubmitInfoResponseDTO submitInfoResponseDTO = new SubmitInfoResponseDTO();
            submitInfoResponseDTO.setId(submitInfo.getId());
            submitInfoResponseDTO.setSpeaker_id(submitInfo.getSpeaker_id());
            submitInfoResponseDTO.setDate(submitInfo.getDate());
            submitInfoResponseDTO.setTopic(submitInfo.getTopic());
            submitInfoResponseDTO.setContent(submitInfo.getContent());
            submitInfoResponseDTOList.add(submitInfoResponseDTO);
        }

        return submitInfoResponseDTOList;
    }

    public void saveSubmitInfo(SubmitInfoRequestDTO requestDTO) {
        SubmitInfo submitInfo = new SubmitInfo();
        submitInfo.setSpeaker_id(requestDTO.getSpeaker_id());
        submitInfo.setDate(requestDTO.getDate());
        submitInfo.setTopic(requestDTO.getTopic());
        submitInfo.setContent(requestDTO.getContent());

        essentialRepository.save(submitInfo);
    }
}
