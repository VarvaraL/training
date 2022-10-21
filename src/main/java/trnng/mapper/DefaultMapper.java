package trnng.mapper;

public interface DefaultMapper<R, S> {
    R mapTo(S s);
}
