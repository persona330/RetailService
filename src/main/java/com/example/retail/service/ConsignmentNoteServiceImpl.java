package com.example.retail.service;

import com.example.retail.mapper.AddressMapper;
import com.example.retail.mapper.ConsignmentNoteMapper;
import com.example.retail.model.dto.AddressDTO;
import com.example.retail.model.dto.ConsignmentNoteDTO;
import com.example.retail.model.entity.Address;
import com.example.retail.model.entity.ConsignmentNote;
import com.example.retail.repository.AddressRepository;
import com.example.retail.repository.ConsignmentNoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsignmentNoteServiceImpl implements ConsignmentNoteService
{
    private final ConsignmentNoteRepository consignmentNoteRepository;
    private final ConsignmentNoteMapper consignmentNoteMapper;

    @Autowired
    public ConsignmentNoteServiceImpl(ConsignmentNoteRepository consignmentNoteRepository, ConsignmentNoteMapper consignmentNoteMapper)
    {
        this.consignmentNoteRepository = consignmentNoteRepository;
        this.consignmentNoteMapper = consignmentNoteMapper;
    }

    @Override
    public ConsignmentNoteDTO create(ConsignmentNoteDTO consignmentNoteDTO)
    {
        return consignmentNoteMapper.toDTO(consignmentNoteRepository.save(consignmentNoteMapper.toEntity(consignmentNoteDTO)));
    }

    @Override
    public List<ConsignmentNoteDTO> readAll()
    {
        List<ConsignmentNote> consignmentNoteList = consignmentNoteRepository.findAll();
        return consignmentNoteMapper.listToDTO(consignmentNoteList);
    }

    @Override
    public ConsignmentNoteDTO read(Integer id)
    {
        ConsignmentNote consignmentNote = consignmentNoteRepository.getById(id);
        return consignmentNoteMapper.toDTO(consignmentNote);
    }

    @Override
    public ConsignmentNoteDTO update(ConsignmentNoteDTO consignmentNoteDTO, Integer id)
    {
        ConsignmentNote consignmentNote = consignmentNoteRepository.getById(id);
        ConsignmentNote consignmentNotetoEntity = consignmentNoteMapper.toEntity(consignmentNoteDTO);

        if (consignmentNote != null)
        {
            if (consignmentNotetoEntity.getId_ConsignmentNote() == null) consignmentNotetoEntity.setId_ConsignmentNote(consignmentNote.getId_ConsignmentNote());

            if (consignmentNotetoEntity.getNumber() == null) consignmentNotetoEntity.setNumber(consignmentNote.getNumber());

            if (consignmentNotetoEntity.getArrivalDate() == null) consignmentNotetoEntity.setArrivalDate(consignmentNote.getArrivalDate());

            if (!consignmentNotetoEntity.isForReturn()) consignmentNotetoEntity.setForReturn(consignmentNote.isForReturn());

            if (consignmentNotetoEntity.getEmployeeStore() == null) consignmentNotetoEntity.setEmployeeStore(consignmentNote.getEmployeeStore());

            if (consignmentNotetoEntity.getSupplier() == null) consignmentNotetoEntity.setSupplier(consignmentNote.getSupplier());

            return consignmentNoteMapper.toDTO(consignmentNoteRepository.save(consignmentNotetoEntity));
        }
        else return null;
    }

    @Override
    public boolean delete(Integer id)
    {
        ConsignmentNote consignmentNote = consignmentNoteRepository.getOne(id);
        if (consignmentNote != null)
        {
            consignmentNoteRepository.delete(consignmentNote);
            return true;
        }
        else return false;
    }
}
