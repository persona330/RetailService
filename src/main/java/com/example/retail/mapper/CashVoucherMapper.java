package com.example.retail.mapper;

import com.example.retail.model.dto.CashVoucherDTO;
import com.example.retail.model.dto.DeliveryDTO;
import com.example.retail.model.entity.CashVoucher;
import com.example.retail.model.entity.Delivery;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CalculatedSignMapper.class, OrganizationMapper.class, ServiceCostMapper.class})
public interface CashVoucherMapper
{
    @Mappings({
            @Mapping(target = "calculatedSign", source = "calculatedSignDTO"),
            @Mapping(target = "organization", source = "organizationDTO"),
            @Mapping(target = "serviceCost", source = "serviceCostDTO")
    })
    CashVoucher toEntity(CashVoucherDTO dto);
    @Mappings({
            @Mapping(target = "calculatedSignDTO", source = "calculatedSign"),
            @Mapping(target = "organizationDTO", source = "organization"),
            @Mapping(target = "serviceCostDTO", source = "serviceCost")
    })
    CashVoucherDTO toDTO(CashVoucher entity);
    List<CashVoucherDTO> listToDTO(List<CashVoucher> entityList);
}
