package org.sda.assembler;

public interface GenericAssembler {
    public <T,U> T assemble(U u);
}
