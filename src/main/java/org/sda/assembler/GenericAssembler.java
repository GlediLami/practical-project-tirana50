package org.sda.assembler;

public interface GenericAssembler<T,U> {
    public T assemble(U u);
}
