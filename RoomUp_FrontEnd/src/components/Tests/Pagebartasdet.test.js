import React from 'react';
import { render, screen} from '@testing-library/react';
import { MemoryRouter} from "react-router-dom";
import Pagebar from "../../components/pagebartasdet/Pagebartasdet";
import '@testing-library/jest-dom/extend-expect';


test('renders service in pagebar', () => {
    render(<MemoryRouter><Pagebar /></MemoryRouter>);
    const servtype = screen.getByText((content) => {
      return content.includes('Services');
    });
    expect(servtype).toBeInTheDocument();
});