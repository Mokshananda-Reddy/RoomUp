import React from 'react';
import { render, screen} from '@testing-library/react';
import { MemoryRouter} from "react-router-dom";
import Bform from "../../components/bform/Bform";
import '@testing-library/jest-dom/extend-expect';


test('renders manager details in form', () => {
    render(<MemoryRouter><Bform /></MemoryRouter>);
    const details = screen.getByText((content) => {
      return content.includes('Block Manager Details');
    });
    expect(details).toBeInTheDocument();
});

test('renders save details of form', () => {
    render(<MemoryRouter><Bform /></MemoryRouter>);
    const save = screen.getByText((content) => {
      return content.includes('Save');
    });
    expect(save).toBeInTheDocument();
});