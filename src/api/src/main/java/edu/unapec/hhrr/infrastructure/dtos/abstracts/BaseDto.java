package edu.unapec.hhrr.infrastructure.dtos.abstracts;

import lombok.Data;

@Data
public abstract class BaseDto <ID> {
   private ID id;
}
