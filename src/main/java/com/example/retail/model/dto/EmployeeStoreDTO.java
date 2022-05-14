package com.example.retail.model.dto;

import com.example.retail.model.entity.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeStoreDTO extends EmployeeDTO
{
    /** Свойство должность*/
    private PositionDTO position;
    /** Свойство склад*/
    private StoreDTO store;

    public PositionDTO getPositionDTO() { return position; }
    public void setPositionDTO(PositionDTO position) { this.position = position; }

    public StoreDTO getStoreDTO() { return store; }
    public void setStoreDTO(StoreDTO store) { this.store = store; }
}
