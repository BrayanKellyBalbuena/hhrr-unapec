package edu.unapec.hhrr.infrastructure.dtos.abstracts;

import com.google.common.base.Objects;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseDto <ID> {
   private ID id;

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof BaseDto)) return false;
      BaseDto<?> baseDto = (BaseDto<?>) o;
      return Objects.equal(id, baseDto.id);
   }

   @Override
   public int hashCode() {
      return Objects.hashCode(id);
   }
}
