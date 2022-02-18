package com.api.booksmanagement.models.entities;

import com.api.booksmanagement.models.transferables.Transferable;

public interface SerializableEntity {
    Transferable serializeForTransfer();
}
