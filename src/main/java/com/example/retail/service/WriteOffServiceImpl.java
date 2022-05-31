package com.example.retail.service;

import com.example.retail.mapper.AccountMapper;
import com.example.retail.mapper.WriteOffMapper;
import com.example.retail.model.dto.AccountDTO;
import com.example.retail.model.dto.WriteOffDTO;
import com.example.retail.model.entity.Account;
import com.example.retail.model.entity.WriteOff;
import com.example.retail.repository.AccountRepository;
import com.example.retail.repository.WriteOffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WriteOffServiceImpl implements WriteOffService
{
    private final WriteOffRepository writeOffRepository;
    private final WriteOffMapper writeOffMapper;

    @Autowired
    public WriteOffServiceImpl(WriteOffRepository writeOffRepository, WriteOffMapper writeOffMapper)
    {
        this.writeOffRepository = writeOffRepository;
        this.writeOffMapper = writeOffMapper;
    }

    @Override
    public WriteOffDTO create(WriteOffDTO writeOffDTO)
    {
        return writeOffMapper.toDTO(writeOffRepository.save(writeOffMapper.toEntity(writeOffDTO)));
    }

    @Override
    public List<WriteOffDTO> readAll()
    {
        List<WriteOff> writeOffList = writeOffRepository.findAll();
        return writeOffMapper.listToDTO(writeOffList);
    }

    @Override
    public WriteOffDTO read(Integer id)
    {
        WriteOff writeOff = writeOffRepository.getById(id);
        return writeOffMapper.toDTO(writeOff);
    }

    @Override
    public WriteOffDTO update(WriteOffDTO writeOffDTO, Integer id)
    {
        WriteOff writeOff = writeOffRepository.getById(id);
        WriteOff writeOfftoEntity = writeOffMapper.toEntity(writeOffDTO);

        if (writeOff != null)
        {
            if (writeOfftoEntity.getId_WriteOff() == null) writeOfftoEntity.setId_WriteOff(writeOff.getId_WriteOff());

            if (writeOfftoEntity.getWriteOffDate() == null) writeOfftoEntity.setWriteOffDate(writeOff.getWriteOffDate());

            if (writeOfftoEntity.getCause() == null) writeOfftoEntity.setCause(writeOff.getCause());

            if (writeOfftoEntity.getSum() == null) writeOfftoEntity.setSum(writeOff.getSum());

            if (writeOfftoEntity.getQuantity() == 0) writeOfftoEntity.setQuantity(writeOff.getQuantity());

            if (writeOfftoEntity.getProduct() == null) writeOfftoEntity.setProduct(writeOff.getProduct());

            if (writeOfftoEntity.getNomenclature() == null) writeOfftoEntity.setNomenclature(writeOff.getNomenclature());

            return writeOffMapper.toDTO(writeOffRepository.save(writeOfftoEntity));
        }
        else return null;
    }

    @Override
    public boolean delete(Integer id)
    {
        WriteOff writeOff = writeOffRepository.getOne(id);
        if (writeOff != null)
        {
            writeOffRepository.delete(writeOff);
            return true;
        }
        else return false;
    }
}
